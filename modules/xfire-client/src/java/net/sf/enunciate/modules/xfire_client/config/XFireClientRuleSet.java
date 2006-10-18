package net.sf.enunciate.modules.xfire_client.config;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.RuleSetBase;

/**
 * Rules for the configuration of the XFire client module.
 *
 * @author Ryan Heaton
 */
public class XFireClientRuleSet extends RuleSetBase {

  public void addRuleInstances(Digester digester) {
    //allow client package conversions to be configured.
    digester.addObjectCreate("enunciate/modules/xfire-client/package-conversions/convert", ClientPackageConversion.class);
    digester.addSetProperties("enunciate/modules/xfire-client/package-conversions/convert");
    digester.addSetNext("enunciate/modules/xfire-client/package-conversions/convert", "addClientPackageConversion");

    //todo: add rules for configuration of invocation handlers?

    //todo: add rules for configuration of xfire in/out handlers?

  }

  @Override
  public String getNamespaceURI() {
    return "http://enunciate.sf.net";
  }
}