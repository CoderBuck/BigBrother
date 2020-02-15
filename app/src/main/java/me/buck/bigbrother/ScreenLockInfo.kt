package me.buck.bigbrother

import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class ScreenLockInfo (
    @Id
    var id: Long = 0,
    var time:String,

    @Convert(converter = EnumConverter::class, dbType = String::class)
    var emLock: EmLock
)