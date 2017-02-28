package com.twitter.finagle.redis.commands.cluster

import com.twitter.finagle.redis.RedisRequestTest
import com.twitter.finagle.redis.protocol.commands.AddSlots
import com.twitter.finagle.redis.tags.CodecTest
import com.twitter.io.Buf
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class ClusterSuite extends RedisRequestTest {

  test("ADDSLOTS", CodecTest) {
    assert(
      encodeCommand(
        AddSlots(
          Seq(
            Buf.Utf8("foo"),
            Buf.Utf8("bar")
          )
        )
      ) == Seq("CLUSTER", "ADDSLOTS", "foo", "bar")
    )
  }
}
