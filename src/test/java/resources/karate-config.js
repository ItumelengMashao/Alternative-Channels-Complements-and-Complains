function fn() {
      karate.configure('connectTimeout', 1900000);

      //To avoid java.net.SocketTimeoutException: Read timed out while uploading file using File Splitter
      karate.configure('readTimeout', 1900000);

      //DISABLE SSL Certificate Verification
      karate.configure('ssl', true);

      console.log("I have been here");

}

