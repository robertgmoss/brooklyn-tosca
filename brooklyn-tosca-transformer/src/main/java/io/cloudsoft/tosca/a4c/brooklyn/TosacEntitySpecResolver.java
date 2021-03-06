package io.cloudsoft.tosca.a4c.brooklyn;

import java.util.Set;

import org.apache.brooklyn.api.entity.EntitySpec;
import org.apache.brooklyn.api.mgmt.classloading.BrooklynClassLoadingContext;
import org.apache.brooklyn.core.resolve.entity.AbstractEntitySpecResolver;

public class TosacEntitySpecResolver extends AbstractEntitySpecResolver {

    private static final String RESOLVER_NAME = "alien4cloud_deployment_topology";

    public TosacEntitySpecResolver() {
        super(RESOLVER_NAME);
    }

    @Override
    public EntitySpec<?> resolve(String type, BrooklynClassLoadingContext loader, Set<String> encounteredTypes) {
        ToscaPlanToSpecTransformer transformer = new ToscaPlanToSpecTransformer();
        transformer.setManagementContext(mgmt);

        return transformer.createApplicationSpecFromTopologyId(getLocalType(type));
    }
}
