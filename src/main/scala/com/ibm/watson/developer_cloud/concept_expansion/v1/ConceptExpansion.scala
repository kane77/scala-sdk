// Copyright (C) 2016 IBM Corp. All Rights Reserved.
// See the LICENCE.txt file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.ibm.watson.developer_cloud.concept_expansion.v1

import com.ibm.watson.developer_cloud.concept_expansion.v1.model.{StatusEnum, Concept, Dataset, Job}
import com.ibm.watson.developer_cloud.service.{ConfigFactory, VCAPConfigFactory, WatsonService}
import com.ibm.watson.developer_cloud.utils.Validation

import scala.concurrent.Future
import model.ConceptExpansionProtocol._
import spray.json._
import spray.client.pipelining._
import spray.http._
import spray.json.DefaultJsonProtocol._
import spray.httpx.SprayJsonSupport._
import ConceptExpansion._
/**
  * Created by Martin Harvan on 10/04/16.
  */
class ConceptExpansion(val dataset: Dataset = new Dataset("Medical Transcription", "mtsamples"),
                       override val configFactory: ConfigFactory = new VCAPConfigFactory())
  extends WatsonService(configFactory) {

  def serviceType: String = "concept_expansion"

  def createJob(seeds: List[String]) : Future[Job] = {
    createJob(None, seeds)
  }

  /**
    * Creates a Job
 *
    * @param label A conceptual classification of the seed terms.
    * @param seeds List of terms to be used as seeds
    * @return the Job
    */
  def createJob(label: Option[String], seeds: List[String]) : Future[Job] = {
    Validation.notEmpty(seeds, "Seeds cannot be null or empty")
    Validation.notNull(dataset, "dataset cannot be null")

    val properties : Map[String, JsValue] = label.map(x => "label" -> JsString(x)).toMap ++
      Map("dataset" -> JsString(dataset.id), "seeds" -> JsArray(seeds.map(JsString(_))))

    val data = JsObject(properties)
    val request = Post(upload, data.toString())
    val response = send(request)
    response.map(unmarshal[Job])
  }

  def getJobResult(job: Job) : Future[Concept] = {
    Validation.notNull(job, "job cannot be null")

    val payload = JsObject("jobid"-> JsString(job.id))

    val request = Put(result, payload.toString)
    val response = send(request)
    response.map(unmarshal[Concept])
  }

  def getJobStatus(job: Job) : Future[StatusEnum] = {
    Validation.notNull(job, "Job cannot be empty")

    val request = Get(Uri(ConceptExpansion.status).withQuery("jobid" -> job.id))
    val response = send(request)

    response.map(unmarshal[StatusEnum])
  }

  def withDataset(dataset: Dataset) : ConceptExpansion = {
    new ConceptExpansion(dataset, configFactory)
  }
}

object ConceptExpansion {
  val upload = "/v1/upload"
  val status = "/v1/status"
  val result = "/v1/result"
}
