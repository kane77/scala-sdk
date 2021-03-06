package com.ibm.watson.developer_cloud.language_translation.v2.model

import com.ibm.watson.developer_cloud.service.GenericModel
import spray.json.{RootJsonFormat, DefaultJsonProtocol}

/**
  * Created by Martin Harvan (martin.harvan@sk.ibm.com) on 20/03/16.
  */
case class IdentifiableLanguage(var language: String, var name: String) extends GenericModel
