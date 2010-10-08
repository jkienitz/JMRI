// ConnectionConfig.java

package jmri.jmrix.nce.serialdriver;


/**
 * Definition of objects to handle configuring a layout connection
 * via an NCE SerialDriverAdapter object.
 *
 * @author      Bob Jacobsen   Copyright (C) 2001, 2003
 * @version	$Revision: 1.8 $
 */
public class ConnectionConfig  extends jmri.jmrix.AbstractSerialConnectionConfig {

	public final static String NAME = "Serial";
	
    /**
     * Ctor for an object being created during load process;
     * Swing init is deferred.
     */
    public ConnectionConfig(jmri.jmrix.SerialPortAdapter p){
        super(p);
    }
    /**
     * Ctor for a functional Swing object with no existing adapter
     */
    public ConnectionConfig() {
        super();
    }

    public String name() { return NAME; }
    
    protected void setInstance() {
    	adapter = SerialDriverAdapter.instance();
    }

}

