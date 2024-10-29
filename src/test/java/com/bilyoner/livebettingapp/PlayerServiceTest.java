package com.bilyoner.livebettingapp;

import com.bilyoner.livebettingapp.model.entity.Player;
import com.bilyoner.livebettingapp.model.request.PlayerCreateRequest;
import com.bilyoner.livebettingapp.model.response.PlayerCreateResponse;
import com.bilyoner.livebettingapp.repository.PlayerRepository;
import com.bilyoner.livebettingapp.service.PlayerService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.bilyoner.livebettingapp.model.entity.Player.PlayerBuilder.aPlayer;
import static com.bilyoner.livebettingapp.model.request.PlayerCreateRequest.PlayerCreateRequestBuilder.aPlayerCreateRequest;
import static com.bilyoner.livebettingapp.model.response.PlayerCreateResponse.PlayerCreateResponseBuilder.aPlayerCreateResponse;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    @InjectMocks
    private PlayerService playerService;

    @Mock
    private PlayerRepository playerRepository;

    @Nested
    class GetPlayers {

        @Test
        void it_should_get_players_when_empty_result() {
            // given
            Mockito.when(playerRepository.findAll()).thenReturn(List.of());

            // when
            final var actual = playerService.getPlayers();

            // then
            assertThat(actual).isEmpty();

            System.out.println("TEST - it_should_get_players_when_empty_result - succesfully passed!");

        }

        @Test
        void it_should_get_players() {
            // given
            Player player = aPlayer()
                    .id(1L)
                    .name("Ömer")
                    .name("Kaya")
                    .build();

            Mockito.when(playerRepository.findAll()).thenReturn(List.of(player));

            // when
            final var actual = playerService.getPlayers();

            // then
            PlayerCreateResponse expectedPlayer = aPlayerCreateResponse()
                    .id(1L)
                    .name("Ömer")
                    .name("Kaya")
                    .build();

            assertThat(actual).containsExactly(expectedPlayer);
        }
    }

    @Nested
    class GetPlayer {

        @Test
        void it_should_get_player() {
            // given
            Player player = aPlayer()
                    .id(1L)
                    .name("Ömer")
                    .name("Kaya")
                    .build();

            Mockito.when(playerRepository.findById(1L)).thenReturn(Optional.of(player));

            // when
            final var actual = playerService.getPlayer(player.getId());


            // then
            PlayerCreateResponse expectedPlayer = aPlayerCreateResponse()
                    .id(1L)
                    .name("Ömer")
                    .name("Kaya")
                    .build();

            assertThat(actual).isEqualTo(expectedPlayer);
        }
    }

    @Nested
    class Save {

        @Test
        void it_should_save() {
            // given
            PlayerCreateRequest request = aPlayerCreateRequest()
                    .name("Ömer")
                    .name("Kaya")
                    .build();

            // when
            playerService.save(request);

            Player player = aPlayer()
                    .name("Ömer")
                    .name("Kaya")
                    .build();

            // then
            Mockito.verify(playerRepository).save(player);
        }
    }
}