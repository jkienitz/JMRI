package jmri.jmrit.jython;

import jmri.util.JUnitUtil;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Invokes complete set of tests in the jmri.jmrit.jython tree
 *
 * @author	Bob Jacobsen Copyright 2001, 2003, 2012
 */
public class PackageTest extends TestCase {

    // from here down is testing infrastructure
    public PackageTest(String s) {
        super(s);
    }

    // Main entry point
    static public void main(String[] args) {
        String[] testCaseName = {"-noloading", PackageTest.class.getName()};
        junit.textui.TestRunner.main(testCaseName);
    }

    // test suite from all defined tests
    public static Test suite() {
        TestSuite suite = new TestSuite("jmri.jmrit.jython.PackageTest");   // no tests in this class itself

        suite.addTest(new JUnit4TestAdapter(BundleTest.class));

        suite.addTest(new JUnit4TestAdapter(JythonWindowsTest.class));

        suite.addTest(SampleScriptTest.suite());
        suite.addTest(new JUnit4TestAdapter(InputWindowActionTest.class));
        suite.addTest(new JUnit4TestAdapter(InputWindowTest.class));
        suite.addTest(new JUnit4TestAdapter(JynstrumentFactoryTest.class));
        suite.addTest(new JUnit4TestAdapter(JythonWindowTest.class));
        suite.addTest(new JUnit4TestAdapter(JynstrumentTest.class));
        suite.addTest(new JUnit4TestAdapter(JynstrumentPopupMenuTest.class));
        suite.addTest(new JUnit4TestAdapter(RunJythonScriptTest.class));

        return suite;
    }

    // The minimal setup for log4J
    @Override
    protected void setUp() {
        JUnitUtil.setUp();
    }

    @Override
    protected void tearDown() {
        JUnitUtil.tearDown();
    }
}
