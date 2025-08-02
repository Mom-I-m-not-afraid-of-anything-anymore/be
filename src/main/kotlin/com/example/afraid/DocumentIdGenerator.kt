package com.example.afraid

import java.util.UUID
import kotlin.text.replace

fun generateDocumentId(): String = UUID.randomUUID().toString().replace("-", "")
