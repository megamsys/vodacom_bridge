package Isis;


/**
* Isis/AttributeListHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from IsisCommon.idl
* Tuesday, December 6, 2016 9:17:28 PM IST
*/


// List of Attributes
public final class AttributeListHolder implements org.omg.CORBA.portable.Streamable
{
  public Isis.Attrib value[] = null;

  public AttributeListHolder ()
  {
  }

  public AttributeListHolder (Isis.Attrib[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Isis.AttributeListHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Isis.AttributeListHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Isis.AttributeListHelper.type ();
  }

}