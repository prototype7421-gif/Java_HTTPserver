# 7/10/26
well after doing some basic c++/c prgramming
lets start
# how do client and server interact with each other?
well 
>TCP Sockets
TCP - transmission control protocol
> it provides bytestreams between two endpoints.
it cant understand "hello"
>thts why it talks in byte.
> wt is sockets?
well its a communication endpoint 
and file descriptor helps us to refer resources to the process
# what is IP address?
well in simple words it tells us the location of the machine on a network.
# what is a PORT?
to access a service in a machine it has a specified port.
            SERVER
              │
              ▼
          socket()
              │
              ▼
           bind()
              │
              ▼
          listen()
              │
              ▼
          accept()
              │
              ▼
       client connection
              │
              ▼
        receive/send
              │
              ▼
           close()

           well 
           1) sockets create endpoints and then 
           2)bind gives and IP address and port to access the server
           3)listen is like it create a listening socket which allows the client to enter the server
           4)accept it creates a  connected socket tht tells the os to interact with client.
           curl/browser
      ↓
localhost:8080
      ↓
TCP server
      ↓
connection accepted
      ↓
server sends simple bytes
      ↓
client receives them
# 10/10/26
# HyperPage Java Server — Learning Notes

## 1. The `bind()` Function

`bind()` associates a socket with a local IP address and port number.

* **IP address:** Identifies the network interface or address on which the server should listen.
* **Port number:** Identifies the communication endpoint for the server application.

For example, a server can use `127.0.0.1` with port `8080` to accept local connections during development.

## 2. Blocking and the `accept()` Operation

A blocking operation makes the current thread wait until the operation completes or an error occurs.

When a server calls `accept()` and no client is connecting:

* The current thread waits for an incoming connection.
* It does not continuously execute instructions while waiting.
* Therefore, it does not normally consume 100% CPU simply because it is blocked.
* When a client connects, `accept()` returns a connected socket.

The operating system can schedule other runnable threads and processes while the server thread waits.

**Important:** Blocking does not mean that the CPU is blocked. It means that the current thread is waiting.

## 3. Listening Socket vs. Connected Socket

A server uses two types of socket roles.

### Listening Socket

* Waits for incoming client connections.
* Accepts new connections through `accept()`.
* Remains available to accept further connections.

### Connected Socket

* Represents an established connection with a particular client.
* Allows the server to receive data from and send data to that client.
* Is returned by `accept()` when a connection is accepted.

For example, if Client A and Client B connect, the server can have one listening socket and separate connected sockets for both clients.

**Key point:** These sockets have different responsibilities. Their separation is not caused by multithreading; even a single-threaded server uses them.

## 4. Blocking Servers and Multiple Clients

A simple single-threaded blocking server handles operations sequentially.

If it is busy communicating with one client, it cannot simultaneously process another client's request on the same thread. Other incoming connections may wait in the operating system's pending connection queue.

Multithreading and other concurrency techniques can help a server handle multiple clients more effectively.

## 5. Sending and Receiving Data Through Sockets

After a connection is established, the client and server can exchange data.

In Java, two important concepts are:

* **InputStream:** Reads incoming bytes from a socket.
* **OutputStream:** Sends outgoing bytes through a socket.

These names describe data flow from the perspective of the program using the stream.

For a server, a client's request is incoming data, while the server's response is outgoing data.

## 6. TCP Is a Byte Stream

TCP provides a reliable, ordered stream of bytes. However, it does not preserve application-level message boundaries.

Suppose a client sends the five characters `HELLO`. The server might receive them through separate read operations, such as:

* First read: `HEL`
* Second read: `LO`

This does not mean that TCP lost data. It means that a single read operation is not guaranteed to return all the bytes sent by the client.

Similarly, one read operation can return bytes belonging to multiple application messages.

Therefore, the server must determine when a complete request has arrived. It cannot assume that one read operation always equals one complete message.

## 7. Relationship Between TCP and HTTP

TCP handles the transport of bytes, while HTTP defines how those bytes represent web requests and responses.

An HTTP request contains information such as:

* HTTP method, such as `GET` or `POST`
* Requested path, such as `/`
* Headers
* An optional body

The server must interpret the request and generate an appropriate HTTP response.

### Learning Sequence for HyperPage

1. Establish TCP connections using Java sockets.
2. Understand sending and receiving bytes.
3. Handle TCP stream reading and request boundaries.
4. Parse HTTP requests.
5. Construct HTTP responses.
6. Handle multiple clients.
7. Add routing, static file serving, and other server features.

## Key Takeaways

* `bind()` associates a socket with a local IP address and port.
* A blocked thread waits; it does not continuously use CPU just to wait.
* A listening socket accepts connections, while a connected socket communicates with a particular client.
* Java socket streams transfer data as bytes.
* TCP preserves byte order but does not preserve application-level message boundaries.
* HTTP defines the structure and meaning of web requests and responses.

# 11/10/26
learnt about how server handles HTTPS request 
> well when the bytestream of data is understand by the server 
it may happen tht all the info isnt coming all at once
so the server needs to indentify the body and context behindn the request
GET= its an HTTP request made by the client
/= well to define a path wt the client actually need from the server
POST= sever fetches the data and give it back aS an HTTP response.

 > what is Routing?
well its a rule tht controls the application behaviour between and path and HTTP request.
