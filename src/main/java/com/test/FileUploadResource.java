package com.test;

import java.util.List;
import java.util.Map;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.wicket.protocol.http.servlet.MultipartServletWebRequest;
import org.apache.wicket.protocol.http.servlet.ServletWebRequest;
import org.apache.wicket.request.resource.AbstractResource;
import org.apache.wicket.util.lang.Bytes;
import org.slf4j.LoggerFactory;

/**
 * @author verhage
 * @since 7/29/16 11:13
 */
public class FileUploadResource extends AbstractResource
{
	@Override
	protected ResourceResponse newResourceResponse(Attributes attributes)
	{
		ServletWebRequest request = (ServletWebRequest) attributes.getRequest();

		try
		{
			MultipartServletWebRequest multipartRequest = request
			 .newMultipartWebRequest(Bytes.megabytes(100), "ignored");
			Map<String, List<FileItem>> files = multipartRequest.getFiles();

			List<FileItem> fileItems = files.get("file");
			for (FileItem fileItem : fileItems)
			{
				saveFile(fileItem);
			}
		}
		catch (FileUploadException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	private void saveFile(FileItem fileItem)
	{
		// not implemented
	}
}
