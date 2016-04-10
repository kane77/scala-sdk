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
package com.ibm.watson.developer_cloud.concept_expansion.v1.model

import com.ibm.watson.developer_cloud.service.GenericModel

/**
  * Created by Martin Harvan (martin.harvan@sk.ibm.com) on 10/04/16.
  */
case class Job(id: String, status: StatusEnum) extends GenericModel

class StatusEnum(val name: String, val id:String)

object StatusEnum {
  val Done = new StatusEnum("Done", "D")
  val Failed = new StatusEnum("Failed", "F")
  val AwaitingWork = new StatusEnum("Awaiting Work", "A")
  val InFlight = new StatusEnum("In Flight", "G")
  val Retrieved = new StatusEnum("Retrieved", "R")
  val enumMap = Map(Done.id -> Done, Failed.id -> Failed, AwaitingWork.id -> AwaitingWork,
    InFlight.id -> InFlight, Retrieved.id -> Retrieved)

  def byId(id: String) : Option[StatusEnum] = {
    enumMap.get(id)
  }
}