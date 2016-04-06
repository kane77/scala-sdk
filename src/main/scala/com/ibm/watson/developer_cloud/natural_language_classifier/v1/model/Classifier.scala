package com.ibm.watson.developer_cloud.natural_language_classifier.v1.model

import com.ibm.watson.developer_cloud.service.GenericModel

/**
  * Created by martinhrvn on 20/03/16.
  */
case class Classifier(var id : String, var url: String, var status: String, var statusDescription: String)extends GenericModel