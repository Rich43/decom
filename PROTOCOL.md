# Projector Communication Protocol

This document summarizes how the mobile app interacts with a Kodak Luma projector.

## 1. User Registration
The app registers users with Kodak servers using JSON over HTTP `POST` requests. Two server endpoints are referenced:

- `http://polaroidapps.testurapp.com/dev/kodak-api/Projector/register`
- `http://projector.smilecdn.site/kodak-api/Projector/register`

Example request body:
```json
{
  "name": "Example User",
  "password": " ",
  "email": "user@example.com",
  "dob": "1 jan 2019",
  "login_with": "social",
  "app_version_number": "1.0",
  "platform": "platform"
}
```
The response includes a `message` field such as `"Data insert successfully."` or `"You are already registered."`.

## 2. Remote Control Commands
Remote control uses the bundled **EShare** API, which opens a TCP socket to the projector (default port `8888`). Messages are plain text terminated by a blank line.

### Key events
```
KEYEVENT\r\n<keycode>\r\n\r\n
```
Example sending the ENTER key (`66`):
```
KEYEVENT
66

```

### Touch events
```
TOUCHEVENT\r\n<action>\r\n[={x,y}...]\r\n\r\n
```
`<action>` is the MotionEvent action code. Coordinates are scaled to the projector's resolution. `MIRRORTOUCHEVENT` uses the same format when mirroring.

### Gyroscope (air‑mouse)
```
GYROSCOPEEVENT\r\n<x>\r\n<y>\r\n<state>\r\n\r\n
```
`<x>` and `<y>` are sensor values; `<state>` is the current touch state (0=down,1=up,2=move).

All commands are written to the socket and flushed immediately.

## 3. Screen Capture
The app captures the projector’s display with an HTTP `GET` request:

```
http://<projector-ip>:8000/remote/screencapture
```

The response is a PNG image stored in the phone's `DCIM/Camera` directory.

## 4. Wireless Storage
When wireless storage is enabled, the app exposes an HTTP server for file transfer. The user is shown a URL in the form:

```
http://<phone-ip>:<port>
```

The projector or a browser can connect to this address to access the device’s storage.

