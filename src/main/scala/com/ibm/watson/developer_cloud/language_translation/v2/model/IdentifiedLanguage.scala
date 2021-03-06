package com.ibm.watson.developer_cloud.language_translation.v2.model

import com.ibm.watson.developer_cloud.service.GenericModel

/**
  * Created by Martin Harvan (martin.harvan@sk.ibm.com) on 20/03/16.
  */
case class IdentifiedLanguage(var language: String, var confidence: Double)extends GenericModel
