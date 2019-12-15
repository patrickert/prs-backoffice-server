package com.prs.backoffice.log
import org.springframework.data.mongodb.repository.MongoRepository


interface LogRepository : MongoRepository<Log, String>