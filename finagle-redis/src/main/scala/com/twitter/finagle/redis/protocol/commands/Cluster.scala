package com.twitter.finagle.redis.protocol.commands

import com.twitter.finagle.redis.protocol.Command
import com.twitter.finagle.redis.util.{BufToString, StringToBuf}
import com.twitter.io.Buf

case class AddSlots(slots: Seq[Buf]) extends Command {
  def name: Buf = Command.CLUSTER
  override def body: Seq[Buf] =
    // CLUSTER ADDSLOTS is actually a subcommand, so we have to send "CLUSTER" and "ADDSLOTS"
    Seq(Buf.Utf8("ADDSLOTS")) ++ slots
}
