package jmri.jmrit.symbolicprog.tabbedframe;

import java.awt.GraphicsEnvironment;
import jmri.jmrit.decoderdefn.DecoderFile;
import jmri.jmrit.roster.RosterEntry;
import org.jdom2.DocType;
import org.jdom2.Document;
import org.jdom2.Element;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class PaneOpsProgFrameTest {

    @Test
    public void testCTor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        jmri.Programmer p = jmri.InstanceManager.getDefault(jmri.AddressedProgrammerManager.class).getAddressedProgrammer(false,42);
        DecoderFile df = new DecoderFile("NMRA", "", "NMRA standard CV definitions", "0", "255",
                "NMRA standard CV definitions", "0NMRA.xml", 16, 3, root);
        RosterEntry re = new RosterEntry();
        PaneOpsProgFrame t = new PaneOpsProgFrame(df,re,"test frame", "programmers/Basic.xml",p);
        Assert.assertNotNull("exists",t);
        t.dispose();
    }

    // The minimal setup for log4J
    @Before
    public void setUp() {
        jmri.util.JUnitUtil.setUp();
        jmri.util.JUnitUtil.initDebugProgrammerManager();
        setupDoc();
    }

    @After
    public void tearDown() {
        jmri.util.JUnitUtil.tearDown();
    }

    // variables for the test XML structures
    private Element root = null;
    private Document doc = null;
    private Element decoderIndexElement = null;
    private Element family1 = null;
    private Element family2 = null;

    // provide a test document in the above static variables
    void setupDoc() {
        // create a JDOM tree with just some elements
        root = new Element("decoderIndex-config");
        doc = new Document(root);
        doc.setDocType(new DocType("decoderIndex-config", "decoderIndex-config.dtd"));

        // add some elements
        root.addContent(decoderIndexElement = new Element("decoderIndex")
                .addContent(new Element("mfgList")
                        .addContent(new Element("manufacturer")
                                .setAttribute("mfg", "NMRA")
                        )
                        .addContent(new Element("manufacturer")
                                .setAttribute("mfg", "Digitrax")
                                .setAttribute("mfgID", "129")
                        )
                )
                .addContent(new Element("familyList")
                        .addContent(family1 = new Element("family")
                                .setAttribute("mfg", "NMRA")
                                .setAttribute("name", "NMRA S&RP definitions")
                                .setAttribute("file", "NMRA.xml")
                                .addContent(new Element("model")
                                        .setAttribute("model", "full set")
                                        .setAttribute("comment", "all CVs in RP 9.2.1")
                                )
                                .addContent(new Element("model")
                                        .setAttribute("model", "required set")
                                        .setAttribute("comment", "required CVs in RP 9.2.1")
                                )
                        )
                        .addContent(family2 = new Element("family")
                                .setAttribute("mfg", "Digitrax")
                                .setAttribute("name", "FX2 family")
                                .setAttribute("file", "DH142.xml")
                                .addContent(new Element("model")
                                        .setAttribute("model", "DH142")
                                        .setAttribute("numFns", "4")
                                        .setAttribute("numOuts", "2")
                                        .setAttribute("lowVersionID", "21")
                                )
                                .addContent(new Element("model")
                                        .setAttribute("model", "DN142")
                                        .setAttribute("numFns", "5")
                                        .setAttribute("numOuts", "1")
                                        .addContent(new Element("versionCV")
                                                .setAttribute("lowVersionID", "22")
                                                .setAttribute("highVersionID", "24")
                                        )
                                )
                        )
                )
        ); // end of adding contents

        return;
    }


    private final static Logger log = LoggerFactory.getLogger(PaneOpsProgFrameTest.class.getName());

}
