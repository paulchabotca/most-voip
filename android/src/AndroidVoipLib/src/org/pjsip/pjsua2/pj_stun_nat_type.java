/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public final class pj_stun_nat_type {
  public final static pj_stun_nat_type PJ_STUN_NAT_TYPE_UNKNOWN = new pj_stun_nat_type("PJ_STUN_NAT_TYPE_UNKNOWN");
  public final static pj_stun_nat_type PJ_STUN_NAT_TYPE_ERR_UNKNOWN = new pj_stun_nat_type("PJ_STUN_NAT_TYPE_ERR_UNKNOWN");
  public final static pj_stun_nat_type PJ_STUN_NAT_TYPE_OPEN = new pj_stun_nat_type("PJ_STUN_NAT_TYPE_OPEN");
  public final static pj_stun_nat_type PJ_STUN_NAT_TYPE_BLOCKED = new pj_stun_nat_type("PJ_STUN_NAT_TYPE_BLOCKED");
  public final static pj_stun_nat_type PJ_STUN_NAT_TYPE_SYMMETRIC_UDP = new pj_stun_nat_type("PJ_STUN_NAT_TYPE_SYMMETRIC_UDP");
  public final static pj_stun_nat_type PJ_STUN_NAT_TYPE_FULL_CONE = new pj_stun_nat_type("PJ_STUN_NAT_TYPE_FULL_CONE");
  public final static pj_stun_nat_type PJ_STUN_NAT_TYPE_SYMMETRIC = new pj_stun_nat_type("PJ_STUN_NAT_TYPE_SYMMETRIC");
  public final static pj_stun_nat_type PJ_STUN_NAT_TYPE_RESTRICTED = new pj_stun_nat_type("PJ_STUN_NAT_TYPE_RESTRICTED");
  public final static pj_stun_nat_type PJ_STUN_NAT_TYPE_PORT_RESTRICTED = new pj_stun_nat_type("PJ_STUN_NAT_TYPE_PORT_RESTRICTED");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static pj_stun_nat_type swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + pj_stun_nat_type.class + " with value " + swigValue);
  }

  private pj_stun_nat_type(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private pj_stun_nat_type(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private pj_stun_nat_type(String swigName, pj_stun_nat_type swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static pj_stun_nat_type[] swigValues = { PJ_STUN_NAT_TYPE_UNKNOWN, PJ_STUN_NAT_TYPE_ERR_UNKNOWN, PJ_STUN_NAT_TYPE_OPEN, PJ_STUN_NAT_TYPE_BLOCKED, PJ_STUN_NAT_TYPE_SYMMETRIC_UDP, PJ_STUN_NAT_TYPE_FULL_CONE, PJ_STUN_NAT_TYPE_SYMMETRIC, PJ_STUN_NAT_TYPE_RESTRICTED, PJ_STUN_NAT_TYPE_PORT_RESTRICTED };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

