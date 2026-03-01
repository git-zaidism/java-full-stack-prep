package org.zaidism.design.lld.solid;

interface CrudService {
    void save();
    void update();
    void delete();
    void fetch();
}

// ReportingService only need get operation but still overring other method which voilates interface seggrigation
class ReportingService implements CrudService {

    @Override
    public void save() {
        throw new UnsupportedOperationException("Reporting is read-only");

    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Reporting is read-only");

    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Reporting is read-only");
    }

    @Override
    public void fetch() {
        System.out.println("reports fetched");
    }
}
// above CrudService interface should be divide into below 2 different interface
interface ReadService {
    void fetch();
}

interface WriteService {
    void save();
    void update();
    void delete();
}

public class InterfaceSeggrigation {
}
