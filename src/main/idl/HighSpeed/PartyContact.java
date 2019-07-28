package HighSpeed;


/**
* HighSpeed/PartyContact.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from HighSpeedExt.idl
* Tuesday, December 6, 2016 9:17:28 PM IST
*/

public final class PartyContact implements org.omg.CORBA.portable.IDLEntity
{
  public int seq = (int)0;

  // Unique ID
  public String addressInd = null;

  // Type of Address (postal or physical) Indicator
  public String fromDate = null;

  // Date subscriber attain address
  public String address1 = null;

  // Flat, House or P.O. Box number
  public String address2 = null;

  // Street Name
  public String address3 = null;

  // Additional address information
  public String suburb = null;

  // Suburb
  public String town = null;

  // City/Town
  public String toDate = null;

  // Date subscriber relocated
  public String postalCode = null;

  // Postal Code
  public String countryId = null;

  // ID for country of residence
  public String region = null;

  public PartyContact ()
  {
  } // ctor

  public PartyContact (int _seq, String _addressInd, String _fromDate, String _address1, String _address2, String _address3, String _suburb, String _town, String _toDate, String _postalCode, String _countryId, String _region)
  {
    seq = _seq;
    addressInd = _addressInd;
    fromDate = _fromDate;
    address1 = _address1;
    address2 = _address2;
    address3 = _address3;
    suburb = _suburb;
    town = _town;
    toDate = _toDate;
    postalCode = _postalCode;
    countryId = _countryId;
    region = _region;
  } // ctor

} // class PartyContact