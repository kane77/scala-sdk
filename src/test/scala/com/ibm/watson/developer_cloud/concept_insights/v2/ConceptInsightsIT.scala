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
package com.ibm.watson.developer_cloud.concept_insights.v2

import akka.actor.ActorSystem
import com.ibm.watson.developer_cloud.concept_insights.v2.model.{Graph}

import com.ibm.watson.developer_cloud.service.{ConfigFactory, LocalFileConfigFactory}
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Millis, Seconds, Span}
import spray.httpx.SprayJsonSupport._
import org.scalatest.{FlatSpec, FunSuite, Matchers}

/**
  * Created by Martin Harvan on 12/04/16.
  */
class ConceptInsightsIT extends FlatSpec with ScalaFutures with Matchers{
    val config : ConfigFactory = LocalFileConfigFactory("/vcap_services.json")
    val service = new ConceptInsights(Some("wikipedia"), config)

    implicit val system = ActorSystem()
    implicit val defaultPatience =
        PatienceConfig(timeout = Span(15, Seconds), interval = Span(500, Millis))

    "Annotation" should "return annotations" in {
        val annotations = service.annotateText(Graph.Wikipedia, "Nizar Magboul Alseddeg is currently living in Austin Texas")
        assert(annotations.futureValue.annotations.nonEmpty)
    }
}
