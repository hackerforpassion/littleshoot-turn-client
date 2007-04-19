package org.lastbamboo.common.turn.client;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import junit.framework.TestCase;

import org.easymock.MockControl;

import org.lastbamboo.common.protocol.ReaderWriter;
import org.lastbamboo.common.turn.client.TurnReaderWriterTracker;
import org.lastbamboo.common.turn.client.TurnReaderWriterTrackerImpl;
import org.lastbamboo.common.turn.client.TurnServerListener;
import org.lastbamboo.common.turn.client.TurnServerWriterImpl;
import org.lastbamboo.common.turn.client.stub.ReaderWriterStub;
import org.lastbamboo.common.turn.message.TurnMessageFactory;
import org.lastbamboo.common.turn.message.TurnMessageFactoryImpl;
import org.lastbamboo.common.util.NetworkUtils;

/**
 * Tests the class for writing messages to TURN servers.
 */
public final class TurnServerWriterImplTest extends TestCase
    {

    /**
     * Tests the send method to make sure it waits appropriately for a response.
     *
     * @throws Exception If any unexpected error occurs.
     */
    public void testWriteSendRequest() throws Exception
        {
        final ReaderWriter readerWriter = new ReaderWriterStub();

        final MockControl turnServerListenerControl =
                MockControl.createControl (TurnServerListener.class);

        final TurnServerListener turnServerListener =
                (TurnServerListener) turnServerListenerControl.getMock ();

        final TurnMessageFactory messageFactory = new TurnMessageFactoryImpl();
        final InetSocketAddress mappedAddress =
            new InetSocketAddress(NetworkUtils.getLocalHost(), 4322);

        final TurnReaderWriterTracker readerWriterTracker =
            new TurnReaderWriterTrackerImpl();
        final TurnServerWriterImpl server =
            new TurnServerWriterImpl(readerWriter, turnServerListener,
                messageFactory, mappedAddress, readerWriterTracker);
        }

    }
