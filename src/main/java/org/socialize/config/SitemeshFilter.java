package org.socialize.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class SitemeshFilter extends ConfigurableSiteMeshFilter {

	@Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/autores", "/WEB-INF/decorators/tags.jsp")
                .addExcludedPath("/resources/*").addExcludedPath("/decorators/*").addExcludedPath("/autores/*").addExcludedPath("/libros/*");
    }
	
}