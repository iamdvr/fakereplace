package org.fakereplace.util;

import javassist.bytecode.AccessFlag;

public class AccessFlagUtils
{
   private AccessFlagUtils()
   {
   }

   public static boolean downgradeVisibility(int n, int o)
   {
      if (AccessFlag.isPrivate(n) && !AccessFlag.isPrivate(o))
      {
         return true;
      }
      if (AccessFlag.isPublic(o) && !AccessFlag.isPublic(n))
      {
         return true;
      }
      if (AccessFlag.isProtected(o) != AccessFlag.isProtected(n))
      {
         return true;
      }
      if (AccessFlag.isPackage(o) != AccessFlag.isPackage(n))
      {
         return true;
      }
      return false;
   }

   public static boolean upgradeVisibility(int n, int o)
   {
      if (AccessFlag.isPrivate(o) && !AccessFlag.isPrivate(n))
      {
         return true;
      }
      if (AccessFlag.isPublic(n) && !AccessFlag.isPublic(o))
      {
         return true;
      }
      return false;
   }

   static final int INVERSE_ACCESS_FLAGS = ~(AccessFlag.PRIVATE | AccessFlag.PUBLIC | AccessFlag.PROTECTED);

   public static boolean accessFlagsDifferent(int n, int o)
   {
      if ((n & INVERSE_ACCESS_FLAGS) != (o & INVERSE_ACCESS_FLAGS))
      {
         return true;
      }
      return false;
   }
}