package com.example.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.model.Follow;
import com.example.model.Message;
import com.example.model.User;
import com.example.repository.FollowRepository;
import com.example.repository.MessageRepository;
import com.example.repository.UserRepository;

import java.time.LocalDateTime;

@Component
public class DataSeeder implements CommandLineRunner {

        private final UserRepository userRepository;
        private final MessageRepository messageRepository;
        private final FollowRepository followRepository;

        public DataSeeder(UserRepository userRepository, MessageRepository messageRepository,
                        FollowRepository followRepository) {
                this.userRepository = userRepository;
                this.messageRepository = messageRepository;
                this.followRepository = followRepository;
        }

        @Override
        public void run(String... args) throws Exception {
                followRepository.deleteAll();
                messageRepository.deleteAll();
                userRepository.deleteAll();

                User user1 = new User("Cristinaalarcon");
                User user2 = new User("Alice");
                User user3 = new User("Bob");
                User user4 = new User("David");
                User user5 = new User("Eve");
                User user6 = new User("Frank");
                User user7 = new User("Grace");
                User user8 = new User("Carlos");
                User user9 = new User("Lucía");
                User user10 = new User("María");

                userRepository.save(user1);
                userRepository.save(user2);
                userRepository.save(user3);
                userRepository.save(user4);
                userRepository.save(user5);
                userRepository.save(user6);
                userRepository.save(user7);
                userRepository.save(user8);
                userRepository.save(user9);
                userRepository.save(user10);

                messageRepository
                                .save(new Message("This is the first tweet", user1,
                                                LocalDateTime.of(2025, 4, 18, 10, 0)));
                messageRepository
                                .save(new Message("This is the second tweet", user2,
                                                LocalDateTime.of(2025, 4, 18, 11, 0)));
                messageRepository
                                .save(new Message("This is the third tweet", user3,
                                                LocalDateTime.of(2025, 4, 18, 12, 0)));
                messageRepository
                                .save(new Message("This is the fourth tweet", user4,
                                                LocalDateTime.of(2025, 4, 18, 13, 0)));
                messageRepository
                                .save(new Message("This is the fifth tweet", user5,
                                                LocalDateTime.of(2025, 4, 18, 14, 0)));
                messageRepository
                                .save(new Message("This is the sixth tweet", user6,
                                                LocalDateTime.of(2025, 4, 18, 15, 0)));
                messageRepository
                                .save(new Message("This is the seventh tweet", user7,
                                                LocalDateTime.of(2025, 4, 18, 16, 0)));
                messageRepository
                                .save(new Message("This is the eighth tweet", user8,
                                                LocalDateTime.of(2025, 4, 18, 17, 0)));
                messageRepository
                                .save(new Message("This is the ninth tweet", user9,
                                                LocalDateTime.of(2025, 4, 18, 18, 0)));
                messageRepository
                                .save(new Message("This is the tenth tweet", user10,
                                                LocalDateTime.of(2025, 4, 18, 19, 0)));

                messageRepository
                                .save(new Message("This is another tweet from Cristinaalarcon", user1,
                                                LocalDateTime.of(2025, 4, 18, 20, 0)));
                messageRepository
                                .save(new Message("Alice's second tweet", user2,
                                                LocalDateTime.of(2025, 4, 18, 21, 0)));
                messageRepository
                                .save(new Message("Bob's second tweet", user3,
                                                LocalDateTime.of(2025, 4, 18, 22, 0)));
                messageRepository
                                .save(new Message("David's second tweet", user4,
                                                LocalDateTime.of(2025, 4, 18, 23, 0)));
                messageRepository
                                .save(new Message("Eve's second tweet", user5,
                                                LocalDateTime.of(2025, 4, 19, 0, 0)));

                messageRepository
                                .save(new Message("Cristinaalarcon's third tweet", user1,
                                                LocalDateTime.of(2025, 4, 19, 1, 0)));
                messageRepository
                                .save(new Message("Alice's third tweet", user2,
                                                LocalDateTime.of(2025, 4, 19, 2, 0)));
                messageRepository
                                .save(new Message("Bob's third tweet", user3,
                                                LocalDateTime.of(2025, 4, 19, 3, 0)));
                messageRepository
                                .save(new Message("David's third tweet", user4,
                                                LocalDateTime.of(2025, 4, 19, 4, 0)));
                messageRepository
                                .save(new Message("Eve's third tweet", user5,
                                                LocalDateTime.of(2025, 4, 19, 5, 0)));
                messageRepository
                                .save(new Message("Frank's second tweet", user6,
                                                LocalDateTime.of(2025, 4, 19, 6, 0)));
                messageRepository
                                .save(new Message("Grace's second tweet", user7,
                                                LocalDateTime.of(2025, 4, 19, 7, 0)));
                messageRepository
                                .save(new Message("Carlos's second tweet", user8,
                                                LocalDateTime.of(2025, 4, 19, 8, 0)));
                messageRepository
                                .save(new Message("Lucía's second tweet", user9,
                                                LocalDateTime.of(2025, 4, 19, 9, 0)));
                messageRepository
                                .save(new Message("María's second tweet", user10,
                                                LocalDateTime.of(2025, 4, 19, 10, 0)));

                followRepository.save(new Follow(user1, user2, LocalDateTime.of(2025, 4, 18, 9, 0)));
                followRepository.save(new Follow(user1, user3, LocalDateTime.of(2025, 4, 18, 9, 30)));
                followRepository.save(new Follow(user2, user3, LocalDateTime.of(2025, 4, 18, 10, 30)));
                followRepository.save(new Follow(user3, user4, LocalDateTime.of(2025, 4, 18, 11, 30)));
                followRepository.save(new Follow(user4, user5, LocalDateTime.of(2025, 4, 18, 12, 30)));
                followRepository.save(new Follow(user5, user1, LocalDateTime.of(2025, 4, 18, 13, 30)));
                followRepository.save(new Follow(user2, user6, LocalDateTime.of(2025, 4, 18, 14, 0)));
                followRepository.save(new Follow(user6, user7, LocalDateTime.of(2025, 4, 18, 15, 30)));
                followRepository.save(new Follow(user7, user3, LocalDateTime.of(2025, 4, 18, 16, 30)));
                followRepository.save(new Follow(user8, user9, LocalDateTime.of(2025, 4, 18, 17, 30)));
                followRepository.save(new Follow(user9, user10, LocalDateTime.of(2025, 4, 18, 18, 30)));
                followRepository.save(new Follow(user10, user1, LocalDateTime.of(2025, 4, 18, 19, 30)));

                System.out.println("Database seeded successfully.");
        }
}
