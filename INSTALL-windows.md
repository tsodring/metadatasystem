Mats reported problems when installing on windows and provided the following steps.

Install Java 8 and update Windows path-environment variable to bin-catalog, 
e.g. C:\Program Files (x86)\Java\jre1.8.0_111\bin (path depends on version)

Download Maven 3.3.9 from http://apache.mirror.anlx.net/maven/maven-3/3.3.9/binaries/
Copy to a catalog of your choice. No installer need to be run.
Update Windows path-environment variable to e.g. C:\maven\bin (depends on install catalog)
(3.3.9 is the current development version for the metasystem-project, and might change in the future.)

Install Java SDK 8 1.7.1 from here: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html 
Preferrably the x64 version.
Download above and run installer. 
Update Windows path-environment variable to C:\Program Files\Java\jdk1.8.0_171\bin (might depend on install catalog, x86 and 64 install to different...)
(1.7.1 is the current development version for the metasystem-project, and might change in the future.)

Set a new Windows environment variable 'JAVA_HOME' to where the JDK is installed(without the /bin), root catalog, not the bin. E.g 'C:\Program Files\Java\jdk1.8.0_171'.

Install GNU Make for Windows from here: http://gnuwin32.sourceforge.net/packages/make.htm
Download and run installer.
Update Windows path-environment variable to C:\Program Files (x86)\GnuWin32\bin (might depend on install catalog)

Continue according to 'Install.md'

To test the API, use e.g. Chrome, Fiddler or curl for Windows here: https://curl.haxx.se/download.html
