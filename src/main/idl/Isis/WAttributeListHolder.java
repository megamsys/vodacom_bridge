package Isis;


/**
* Isis/WAttributeListHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from IsisCommon.idl
* Tuesday, December 6, 2016 9:17:28 PM IST
*/


// List of Wide Attributes
public final class WAttributeListHolder implements org.omg.CORBA.portable.Streamable
{
  public Isis.WAttrib value[] = null;

  public WAttributeListHolder ()
  {
  }

  public WAttributeListHolder (Isis.WAttrib[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Isis.WAttributeListHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Isis.WAttributeListHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Isis.WAttributeListHelper.type ();
  }

}
