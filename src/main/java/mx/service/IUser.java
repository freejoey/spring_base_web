package mx.service;

public interface IUser {
    String getName(long id);

    void setName(String name, long id);

    void changeName(long first, long second);
}
