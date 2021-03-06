package com.ibm.watson.developer_cloud.natural_language_classifier.v1.model

import com.ibm.watson.developer_cloud.service.GenericModel

/**
  * Created by Martin Harvan (martin.harvan@sk.ibm.com) on 20/03/16.
  */
case class Classification(var id: String, var url: String, var text: String, var topClass: String, var classes:  List[ClassifiedClass])extends GenericModel
