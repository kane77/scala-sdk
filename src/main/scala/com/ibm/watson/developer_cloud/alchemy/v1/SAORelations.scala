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
package com.ibm.watson.developer_cloud.alchemy.v1

import com.ibm.watson.developer_cloud.service.GenericModel

/**
  * Created by martinhrvn on 07/04/16.
  */
case class SAORelations(relations: List[SAORelation], text: String, totalTransactions: Integer, language: String,
                        url: String) extends AlchemyLanguageGenericModel {
  def withRelations(relations: List[SAORelation]) : SAORelations = {
    SAORelations(relations, text, totalTransactions,language, url)
  }
}

case class SAORelation(action: Action, objekt: RelationObject, sentence: String, subject: Subject) extends GenericModel
case class Verb(negated: Integer, tense: String, text: String) extends GenericModel
case class Action(lemmatized: String, text: String, verb: Verb) extends GenericModel
case class RelationObject(entity: Entity, keywords: List[Keyword], sentiment: Sentiment, sentimentFromSubject: Sentiment, text: String) extends GenericModel
case class Subject(entity: Entity, keywords: List[Keyword], sentiment: Sentiment, text: String) extends GenericModel