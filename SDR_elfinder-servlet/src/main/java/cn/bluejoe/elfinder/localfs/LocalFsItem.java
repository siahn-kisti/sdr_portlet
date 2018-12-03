package cn.bluejoe.elfinder.localfs;

import java.io.File;

import cn.bluejoe.elfinder.service.FsItem;
import cn.bluejoe.elfinder.service.FsVolume;

public class LocalFsItem implements FsItem
{
	File _file;

	FsVolume _volume;

	public LocalFsItem(LocalFsVolume volume, File file)
	{
		super();
		_volume = volume;
		_file = file;
	}

	public File getFile()
	{
		return _file;
	}

	public FsVolume getVolume()
	{
		return _volume;
	}

	public void setFile(File file)
	{
		_file = file;
	}

	public void setVolume(FsVolume volume)
	{
		_volume = volume;
	}

	@Override
	public String toString()
	{
		return "LocalFsVolume [" + _file + "]";
	}
}
