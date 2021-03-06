package com.marcelmika.lims.jabber.connection;

import com.marcelmika.lims.util.PortletPropsValues;
import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.sasl.SASLPlainMechanism;
import org.jivesoftware.smack.util.Base64;

import javax.security.sasl.Sasl;
import javax.security.sasl.SaslException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Has to be overridden to repair bug in SASLPlainMechanism class from Smack
 *
 * @author Ing. Marcel Mika
 * @link http://marcelmika.com/lims
 * Date: 11/24/13
 * Time: 11:18 PM
 */
public class LiferaySaslMechanism extends SASLPlainMechanism {

    public LiferaySaslMechanism(SASLAuthentication saslAuthentication) {
        super(saslAuthentication);
    }


    @Override
    public void authenticate(String username, String host, String password) throws IOException, XMPPException {

        this.authenticationId = PortletPropsValues.JABBER_SASL_PLAIN_AUTHID;
        this.password = PortletPropsValues.JABBER_SASL_PLAIN_PASSWORD;
        this.hostname = host;

        String[] mechanisms = { getName() };
        Map props = new HashMap();
        this.sc = Sasl.createSaslClient(mechanisms, username, "xmpp", host, props, this);
        authenticate();

    }

    protected void authenticate() throws IOException, XMPPException {
        String authenticationText = null;
        try {
            if (this.sc.hasInitialResponse()) {
                byte[] response = this.sc.evaluateChallenge(new byte[0]);
                authenticationText = Base64.encodeBytes(response, 8);
            }
        } catch (SaslException e) {
            throw new XMPPException("SASL authentication failed", e);
        }

        getSASLAuthentication().send(new AuthMechanism(getName(), authenticationText));
    }

}
