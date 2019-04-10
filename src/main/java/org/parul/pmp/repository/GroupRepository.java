package org.parul.pmp.repository;

import org.parul.pmp.dto.GroupDTO;
import org.parul.pmp.entity.Department;
import org.parul.pmp.entity.Faculty;
import org.parul.pmp.entity.GroupDetails;
import org.parul.pmp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<GroupDetails,Long> {
    Optional<GroupDetails> findByGroupName(String groupName);

    Optional<GroupDetails> findByGroupNameAndYear(String groupName, int thisyear);

    List<GroupDetails> findByDepartment(Department dept);

    List<GroupDetails> findByMentor(Faculty mentor);

    List<GroupDetails> findByDateOfGroupCreation(Instant grpYear);

    Optional<GroupDetails> findByGroupId(Long groupId);

}
