import styled from 'styled-components';

export const FormGroup = styled.div`
  margin-bottom: 16px;

  label {
    display: block;
    margin-bottom: 6px;
    font-size: 14px;
    font-weight: 600;
  }

  input[type="text"],
  input[type="number"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 6px;
    font-size: 15px;

    &:focus {
      outline: none;
      border-color: #4b7bec;
      box-shadow: 0 0 3px rgba(75, 123, 236, 0.4);
    }
  }

  input[type="checkbox"] {
    transform: scale(1.2);
    margin-right: 8px;
  }
`;
