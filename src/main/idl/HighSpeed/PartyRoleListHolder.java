package HighSpeed;


/**
* HighSpeed/PartyRoleListHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from HighSpeedExt.idl
* Tuesday, December 6, 2016 9:17:28 PM IST
*/


// Party Role list
public final class PartyRoleListHolder implements org.omg.CORBA.portable.Streamable
{
  public HighSpeed.PartyRole value[] = null;

  public PartyRoleListHolder ()
  {
  }

  public PartyRoleListHolder (HighSpeed.PartyRole[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = HighSpeed.PartyRoleListHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    HighSpeed.PartyRoleListHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return HighSpeed.PartyRoleListHelper.type ();
  }

}
