module Paths_solution (
    version,
    getBinDir, getLibDir, getDataDir, getLibexecDir,
    getDataFileName
  ) where

import qualified Control.Exception as Exception
import Data.Version (Version(..))
import System.Environment (getEnv)
import Prelude

catchIO :: IO a -> (Exception.IOException -> IO a) -> IO a
catchIO = Exception.catch


version :: Version
version = Version {versionBranch = [0,1,0], versionTags = []}
bindir, libdir, datadir, libexecdir :: FilePath

bindir     = "/usr/people/classes/CS239/labs/Lab05_Sets/solution/bin"
libdir     = "/usr/people/classes/CS239/labs/Lab05_Sets/solution/lib/solution-0.1.0/ghc-7.6.3"
datadir    = "/usr/people/classes/CS239/labs/Lab05_Sets/solution/share/solution-0.1.0"
libexecdir = "/usr/people/classes/CS239/labs/Lab05_Sets/solution/libexec"

getBinDir, getLibDir, getDataDir, getLibexecDir :: IO FilePath
getBinDir = catchIO (getEnv "solution_bindir") (\_ -> return bindir)
getLibDir = catchIO (getEnv "solution_libdir") (\_ -> return libdir)
getDataDir = catchIO (getEnv "solution_datadir") (\_ -> return datadir)
getLibexecDir = catchIO (getEnv "solution_libexecdir") (\_ -> return libexecdir)

getDataFileName :: FilePath -> IO FilePath
getDataFileName name = do
  dir <- getDataDir
  return (dir ++ "/" ++ name)
