package com.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class of classes capable of logging.
 *
 * @author rburawes
 */
public class AppLogger {
    protected Logger log = LoggerFactory.getLogger(getClass());
}