package it309.rms.dataclass;

import java.io.Serializable;


public class ResourceIdInfo  implements Cloneable, Serializable{
  /* {src_lang=Java}*/

    private String resourceId;

    private String resourceType;

    private String resourceTitle;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceTitle() {
        return resourceTitle;
    }

    public void setResourceTitle(String resourceTitle) {
        this.resourceTitle = resourceTitle;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }


  }