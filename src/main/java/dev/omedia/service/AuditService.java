package dev.omedia.service;

import dev.omedia.domain.Audit;
import dev.omedia.domain.Car;
import dev.omedia.domain.User;
import dev.omedia.repository.AuditRepository;
import org.springframework.stereotype.Service;

@Service
public class AuditService {
    private final AuditRepository auditRepository;

    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    public Audit createAudit(Car car) {
        return auditRepository.save(carToAudit(car));
    }

    public Audit createAudit(User user) {
        return auditRepository.save(userToAudit(user));
    }

    private Audit carToAudit(Car car) {
        Audit audit = new Audit();
        audit.setUpdates(car.toString());
        return audit;
    }

    private Audit userToAudit(User user) {
        Audit audit = new Audit();
        audit.setUpdates(user.toString());
        return audit;
    }
}
