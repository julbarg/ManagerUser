package com.claro.manager.ejb;

import javax.ejb.Remote;


@Remote
public interface ProcessFileRemote {

   public boolean processFile(StringBuffer strFile) throws Exception;

   public String validateFileMain(StringBuffer strFile) throws Exception;

}
