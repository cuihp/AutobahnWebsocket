# AutobahnWebsocket

[![](https://jitpack.io/v/cuihp/AutobahnWebsocket.svg)](https://jitpack.io/#cuihp/AutobahnWebsocket)

# How to

* Step 1. Add the JitPack repository to your build file
* Add it in your root build.gradle at the end of repositories:

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
* Step 2. Add the dependency

```
dependencies {
	        compile 'com.github.cuihp:AutobahnWebsocket:V1.0'
	}
```

* Step 3. 简单使用，更多用法查看源码即可

```
 WebSocketConnection webSocketConnection = new WebSocketConnection();
        try {
            webSocketConnection.connect("ws://app.app.cc/", new WebSocketConnectionHandler() {
                @Override
                public void onOpen() {
                    Log.d(TAG, "onOpen");
                }

                @Override
                public void onMessage(String payload) {
                    Log.d(TAG, payload);
                }

                @Override
                public void onClose(int code, String reason) {
                    Log.d(TAG, code + ":" + reason);
                }
            });
        } catch (WebSocketException e) {
            e.printStackTrace();
        }
```