package com.intergraph.ziputil;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Expand;
import java.io.File;


public class DeCompressUtil {
    public static void unzip(String sourceZip, String destDir) throws Exception {
        try {
            Project p = new Project();
            Expand e = new Expand();
            e.setProject(p);
            e.setSrc(new File(sourceZip));
            e.setOverwrite(false);
            e.setDest(new File(destDir));
            e.setEncoding("utf-8");
            e.execute();
        } catch (Exception e) {
            throw e;
        }
    }
}
