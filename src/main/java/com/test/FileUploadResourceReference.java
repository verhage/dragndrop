package com.test;

import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;

/**
 * @author verhage
 * @since 7/29/16 11:04
 */
public class FileUploadResourceReference extends ResourceReference
{
	public FileUploadResourceReference(String name)
	{
		super(FileUploadResourceReference.class, name);
	}

	@Override
	public IResource getResource()
	{
		return new FileUploadResource();
	}
}
