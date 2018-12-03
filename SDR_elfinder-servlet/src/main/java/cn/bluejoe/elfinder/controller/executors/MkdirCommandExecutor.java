package cn.bluejoe.elfinder.controller.executors;

import cn.bluejoe.elfinder.controller.executor.AbstractJsonCommandExecutor;
import cn.bluejoe.elfinder.controller.executor.CommandExecutor;
import cn.bluejoe.elfinder.controller.executor.FsItemEx;
import cn.bluejoe.elfinder.service.FsService;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class MkdirCommandExecutor extends AbstractJsonCommandExecutor implements
		CommandExecutor
{
	Logger _logger = Logger.getLogger(this.getClass());
	
	@Override
	public void execute(FsService fsService, HttpServletRequest request,
			ServletContext servletContext, JSONObject json) throws Exception
	{
		/* - 원본 코드
		 * String target = request.getParameter("target");
		 * String name = request.getParameter("name");
		 *
		 * FsItemEx fsi = super.findItem(fsService, target);
		 * FsItemEx dir = new FsItemEx(fsi, name);
		 * dir.createFolder();
		 *
		 * json.put("added", new Object[] { getFsItemInfo(request, dir) });
		 */

		String target = request.getParameter("target");
		String name = request.getParameter("name");
		String[] dirNames = request.getParameterValues("dirs[]");

		if(name != null) {

			FsItemEx fsi = super.findItem(fsService, target);
			FsItemEx dir = new FsItemEx(fsi, name);
			dir.createFolder();

			json.put("added", new Object[] { getFsItemInfo(request, dir) });

		}else if (dirNames != null && dirNames.length > 0) {

			Object[] object = new Object[dirNames.length];
			int number = 0;

			//_logger.debug(String.format(">>>>Total number of directories: %d", dirNames.length));

			for(String dirName : dirNames) {

				FsItemEx fsi = super.findItem(fsService, target);
				FsItemEx dir = new FsItemEx(fsi, dirName);
				dir.createFolder();

				object[number] = getFsItemInfo(request, fsi);

				if(number % 200 == 0) {
					//_logger.debug(String.format(">>>>Creating directories: %d", number));
				}

				number++;
			}

			//_logger.debug(String.format(">>>>Last Directory Count: %d", number));

			json.put("added", object);

		}else {

			json.put("added", new Object[] {});
		}
	}
}
