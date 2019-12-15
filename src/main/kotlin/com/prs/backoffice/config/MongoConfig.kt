package com.prs.backoffice.config


import com.mongodb.MongoClient
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration


@Configuration
class MongoConfig : AbstractMongoConfiguration() {
    override fun getDatabaseName(): String {
        return "test"
    }

    override fun mongoClient(): MongoClient {
        return MongoClient("127.0.0.1", 27017)
    }

    override fun getMappingBasePackage(): String? {
        return "org.baeldung"
    }
}