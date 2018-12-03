package cn.bluejoe.elfinder.impl;

import java.util.regex.Pattern;

import cn.bluejoe.elfinder.service.FsSecurityChecker;

public class FsSecurityCheckFilterMapping
{
	FsSecurityChecker _checker;

	String _pattern;

	public FsSecurityChecker getChecker()
	{
		return _checker;
	}

	public String getPattern()
	{
		return _pattern;
	}

	public boolean matches(String hash)
	{
		return Pattern.compile(_pattern).matcher(hash).matches();
	}

	public void setChecker(FsSecurityChecker checker)
	{
		_checker = checker;
	}

	public void setPattern(String pattern)
	{
		_pattern = pattern;
	}
}
