package Isis;

/**
* Isis/InterfaceErrorHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from IsisCommon.idl
* Tuesday, December 6, 2016 9:17:28 PM IST
*/


// Interface exception
public final class InterfaceErrorHolder implements org.omg.CORBA.portable.Streamable
{
  public Isis.InterfaceError value = null;

  public InterfaceErrorHolder ()
  {
  }

  public InterfaceErrorHolder (Isis.InterfaceError initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Isis.InterfaceErrorHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Isis.InterfaceErrorHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Isis.InterfaceErrorHelper.type ();
  }

}
