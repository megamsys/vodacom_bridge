package Isis;

/**
* Isis/ErrorGroupHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from IsisCommon.idl
* Tuesday, December 6, 2016 9:17:28 PM IST
*/


// Error groups
public final class ErrorGroupHolder implements org.omg.CORBA.portable.Streamable
{
  public Isis.ErrorGroup value = null;

  public ErrorGroupHolder ()
  {
  }

  public ErrorGroupHolder (Isis.ErrorGroup initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Isis.ErrorGroupHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Isis.ErrorGroupHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Isis.ErrorGroupHelper.type ();
  }

}
