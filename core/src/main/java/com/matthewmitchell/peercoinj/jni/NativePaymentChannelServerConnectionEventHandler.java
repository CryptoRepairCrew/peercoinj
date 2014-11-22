package com.matthewmitchell.peercoinj.jni;

import com.matthewmitchell.peercoinj.core.*;
import com.matthewmitchell.peercoinj.protocols.channels.PaymentChannelCloseException;
import com.matthewmitchell.peercoinj.protocols.channels.ServerConnectionEventHandler;

import java.math.BigInteger;

/**
 * An event listener that relays events to a native C++ object. A pointer to that object is stored in
 * this class using JNI on the native side, thus several instances of this can point to different actual
 * native implementations.
 */
public class NativePaymentChannelServerConnectionEventHandler extends ServerConnectionEventHandler {
    public long ptr;

    @Override
    public native void channelOpen(Sha256Hash channelId);

    @Override
    public native ListenableFuture<ByteString> paymentIncrease(Coin by, Coin to, ByteString info);

    @Override
    public native void channelClosed(PaymentChannelCloseException.CloseReason reason);
}
