package com.ibm.watson.developer_cloud.visual_recognition.v1.model

import com.ibm.watson.developer_cloud.service.GenericModel

/**
  * Created by Martin Harvan (martin.harvan@sk.ibm.com) on 20/03/16.
  */
case class RecognizedImage(id: String, labels: List[Label], name: String) extends GenericModel
